
package path;

/* NetId(s): jcs547, wzs6

 * Name(s): James Sy, Willy Swenson
 * What I thought about this assignment:
 * Implementing the algorithm using the abstract layout from the handout required
 * us to really read into and understand the invariants and purpose of the algorithm.
 * Once we figured this out, we struggled a bit with the implementation, but
 * we were able to figure it out eventually by studying the resources that we were
 * given (handout, JavaHyperText, lecture).
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import graph.Edge;
import graph.Node;

/** This class contains the solution to A7, shortest-path algorithm, <br>
 * and other methods for an undirected graph. */
public class Path {

    /** Replace "-1" by the time you spent on A2 in hours.<br>
     * Example: for 3 hours 15 minutes, use 3.25<br>
     * Example: for 4 hours 30 minutes, use 4.50<br>
     * Example: for 5 hours, use 5 or 5.0 */
    public static double timeSpent= 6;

    /** = the shortest path from node v to node end <br>
     * ---or the empty list if a path does not exist. <br>
     * Note: The empty list is a list with 0 elements ---it is not "null". */
    public static List<Node> shortestPath(Node v, Node end) {
        /* TODO Implement this method.
         * Read the A7 assignment handout for all details.
         * Remember, the graph is undirected. */

        // Contains an entry for each node in the frontier set. The priority of
        // a node is the length of the shortest known path from v to the node
        // using only settled nodes except for the last node, which is in F.
        var F= new Heap<Node>(true);
        F.insert(v, 0);
        Info vInfo= new Info(0, null);

        // Put in a declaration of the HashMap here, with a suitable name
        // for it and a suitable definition of its meaning --what it contains,
        // etc. See Section 10 point 4 of the A7 handout for help.

        // SandF is a HashMap containing all the nodes in the settled set and
        // the frontier set. The key is a node, and the value is an object
        // of type Info which has fields for the shortest distance from the
        // starting node to this one, as well as the backpointer, which is the
        // previous node on this shortest path.
        var SandF= new HashMap<Node, Info>();
        SandF.put(v, vInfo);

        while (F.size() > 0) {
            Node f= F.poll();
            if (f.equals(end)) return pathToEnd(SandF, end);
            var edges= f.exits();
            for (Edge e : edges) {
                int distance= e.length + SandF.get(f).dist;
                var w= e.other(f);
                if (!SandF.containsKey(w)) {
                    F.insert(w, distance);
                    Info wInfo= new Info(distance, f);
                    SandF.put(w, wInfo);
                }

                else if (distance < SandF.get(w).dist) {
                    SandF.get(w).dist= distance;
                    SandF.get(w).bkptr= f;
                    F.changePriority(w, distance);
                }

            }
        }

        // Put all your code before this comment. Do not change this comment or return statement
        // no path from v to end.
        return new LinkedList<>();
    }

    /** An instance contains info about a node: <br>
     * the known shortest distance of this node from the start node and <br>
     * its backpointer: the previous node on a shortest path <br>
     * from the first node to this node (null for the start node). */
    private static class Info {
        /** shortest known distance from the start node to this one. */
        private int dist;
        /** backpointer on path (with shortest known distance) from <br>
         * start node to this one */
        private Node bkptr;

        /** Constructor: an instance with dist d from the start node and<br>
         * backpointer p. */
        private Info(int d, Node p) {
            dist= d;     // Distance from start node to this one.
            bkptr= p;    // Backpointer on the path (null if start node)
        }

        /** = a representation of this instance. */
        @Override
        public String toString() {
            return "dist " + dist + ", bckptr " + bkptr;
        }
    }

    /** = the path from the start node to node end.<br>
     * Precondition: SandF contains all the necessary information about<br>
     * ............. the path. */
    public static List<Node> pathToEnd(HashMap<Node, Info> SandF, Node end) {
        List<Node> path= new LinkedList<>();
        var p= end;
        // invariant: All the nodes from p's successor to node
        // . . . . . .end are in path, in reverse order.
        while (p != null) {
            path.add(0, p);
            p= SandF.get(p).bkptr;
        }
        return path;
    }

    /** = the sum of the weights of the edges on path p. <br>
     * Precondition: p contains at least 1 node. <br>
     * If 1 node, it's a path of length 0, i.e. with no edges. */
    public static int pathSum(List<Node> p) {
        synchronized (p) {
            Node w= null;
            var sum= 0;
            // invariant: if w is null, n is the start node of the path.<br>
            // .......... if w is not null, w is the predecessor of n on the path.
            // .......... sum = sum of weights on edges from first node to v
            for (Node n : p) {
                if (w != null) sum= sum + w.edge(n).length;
                w= n;
            }
            return sum;
        }
    }

}
