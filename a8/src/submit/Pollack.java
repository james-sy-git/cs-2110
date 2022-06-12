package submit;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import graph.FindState;
import graph.Finder;
import graph.FleeState;
import graph.Node;
import graph.NodeStatus;

/** A solution with find-the-Orb optimized and flee getting out as fast as possible. */
public class Pollack extends Finder {

    /** HashMap containing the IDs of locations; value is true if <br>
     * the location has been visited. */
    private HashMap<Long, Boolean> tracker= new HashMap<>();

    /** Get to the orb in as few steps as possible. <br>
     * Once you get there, you must return from the function in order to pick it up. <br>
     * If you continue to move after finding the orb rather than returning, it will not count.<br>
     * If you return from this function while not standing on top of the orb, it will count as <br>
     * a failure.
     *
     * There is no limit to how many steps you can take, but you will receive<br>
     * a score bonus multiplier for finding the orb in fewer steps.
     *
     * At every step, you know only your current tile's ID and the ID of all<br>
     * open neighbor tiles, as well as the distance to the orb at each of <br>
     * these tiles (ignoring walls and obstacles).
     *
     * In order to get information about the current state, use functions<br>
     * currentLoc(), neighbors(), and distanceToOrb() in FindState.<br>
     * You know you are standing on the orb when distanceToOrb() is 0.
     *
     * Use function moveTo(long id) in FindState to move to a neighboring<br>
     * tile by its ID. Doing this will change state to reflect your new position.
     *
     * A suggested first implementation that will always find the orb, but <br>
     * likely won't receive a large bonus multiplier, is a depth-first search. <br>
     * Some modification is necessary to make the search better, in general. */
    @Override
    public void find(FindState state) {
        // TODO 1: Walk to the orb
        walk(state);

    }

    /** = performs an optimized DFS walk from the start Node to the <br>
     * node at which the orb is located. */
    public void walk(FindState state) {
        if (state.distanceToOrb() == 0) return;
        tracker.put(state.currentLoc(), true);
        var current= state.currentLoc();
        Heap<NodeStatus> order= new Heap<NodeStatus>(true);
        for (NodeStatus neighbor : state.neighbors()) {
            order.insert(neighbor, neighbor.getDistanceToTarget());
        }
        while (order.size() != 0) {
            var id= order.poll().getId();
            if (!tracker.containsKey(id)) {
                state.moveTo(id);
                walk(state);
                if (state.distanceToOrb() == 0) return;
                state.moveTo(current);
            }

        }
    }

    /** Get out the cavern before the ceiling collapses, trying to collect as <br>
     * much gold as possible along the way. Your solution must ALWAYS get out <br>
     * before steps runs out, and this should be prioritized above collecting gold.
     *
     * You now have access to the entire underlying graph, which can be accessed <br>
     * through FleeState state. <br>
     * currentNode() and exit() will return Node objects of interest, and <br>
     * allsNodes() will return a collection of all nodes on the graph.
     *
     * Note that the cavern will collapse in the number of steps given by <br>
     * stepsLeft(), and for each step this number is decremented by the <br>
     * weight of the edge taken. <br>
     * Use stepsLeft() to get the steps still remaining, and <br>
     * moveTo() to move to a destination node adjacent to your current node.
     *
     * You must return from this function while standing at the exit. <br>
     * Failing to do so before steps runs out or returning from the wrong <br>
     * location will be considered a failed run.
     *
     * You will always have enough steps to flee using the shortest path from the <br>
     * starting position to the exit, although this will not collect much gold. <br>
     * For this reason, using Dijkstra's to plot the shortest path to the exit <br>
     * is a good starting solution
     *
     * Here's another hint. Whatever you do you will need to traverse a given path. It makes sense
     * to write a method to do this, perhaps with this specification:
     *
     * // Traverse the nodes in moveOut sequentially, starting at the node<br>
     * // pertaining to state <br>
     * // public void moveAlong(FleeState state, List<Node> moveOut) */
    @Override
    public void flee(FleeState state) {
        // TODO 2. Get out of the cavern in time, picking up as much gold as possible.
        grab(state);
    }

    /** = arranges each Node with a Tile containing gold into a max-heap <br>
     * with its priority based on the amount of gold divided by the distance <br>
     * to the current Node. */
    public Node refresh(FleeState state) {
        Heap<Node> distheap= new Heap<Node>(false);
        Collection<Node> all= state.allNodes();
        var current= state.currentNode();
        for (Node somenode : all) {
            var goldamt= somenode.getTile().gold();
            if (goldamt != 0) {
                var dist= distance(current, somenode) == 0 ? 1000 : distance(current, somenode);
                var prio= goldamt / dist;
                if (!distheap.map.containsKey(somenode)) distheap.insert(somenode, prio);
            }
        }

        return distheap.poll();
    }

    /** = returns the integer distance between Node start and Node end. <br>
     * Precondition: neither start nor end are null; in that case there <br>
     * would be no path. */
    public int distance(Node start, Node end) {
        List<Node> path= Path.shortestPath(start, end);
        int sum= Path.pathSum(path);
        return sum;
    }

    /** = calls walkto() to the next gold-containing Node <br>
     * if the distance to the Node and then to the exit is <br>
     * less than the number of steps remaining in the exit sequence. <br>
     * Calls walkto() to the exit otherwise. */
    public void grab(FleeState state) {
        while (!state.currentNode().equals(state.exit())) {
            Node nexttogo= refresh(state);
            if (timetogo(state, nexttogo)) {
                List<Node> nextwalk= Path.shortestPath(state.currentNode(), nexttogo);
                walkto(state, nextwalk);
            } else {
                List<Node> toexit= Path.shortestPath(state.currentNode(), state.exit());
                walkto(state, toexit);
            }
        }

    }

    /** = walks Martha Pollack along path. <br>
     * Precondition: path is a non-null list (signifying that there is a <br>
     * path between the nodes). */
    public void walkto(FleeState state, List<Node> path) {
        for (Node nextnode : path) {
            if (!state.currentNode().equals(nextnode)) {
                state.moveTo(nextnode);
            }
        }
    }

    /** = returns true if the distance to the next Node plus <br>
     * the distance to the exit is less than the number of <br>
     * steps remaining, false otherwise. Precondition: possible is non-null */
    public boolean timetogo(FleeState state, Node possible) {
        var current= state.currentNode();
        var d1= distance(current, possible);
        var d2= distance(possible, state.exit());
        return d1 + d2 <= state.stepsLeft();
    }

}
