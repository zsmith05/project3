public class BTree {
    private static class Node{
        int[] keys;
        int m;
        Node[] child;
        int n;
        boolean isLeaf;


        public Node(int t, boolean isLeaf){
            this.m = m;
            this.isLeaf = isLeaf;
            keys = new int[2*m-1];
            child = new Node[2 * t];
            n = 0;
        }

        public void insertNonFull(int key) {

            int i = n - 1;

            if (isLeaf) {
                // Find the location of the new key to be inserted
                while (i >= 0 && keys[i] > key) {
                    keys[i + 1] = keys[i];
                    i--;
                }
                keys[i + 1] = key;
                n++;
            } else {
                while (i >= 0 && keys[i] > key) {
                    i--;
                }
                if (child[i + 1].n == 2 * m - 1) {
                    splitChild(i + 1, child[i + 1]);
                    if (keys[i + 1] < key) {
                        i++;
                    }
                }
                child[i + 1].insertNonFull(key);
            }
        }

        public void splitChild(int i, Node y) {
            Node z = new Node(y.m, y.isLeaf);
            z.n = m - 1;

            for (int j = 0; j < m - 1; j++) {
                z.keys[j] = y.keys[j + m];
            }

            if (!y.isLeaf) {
                for (int j = 0; j < m; j++) {
                    z.child[j] = y.child[j + m];
                }
            }

            y.n = m - 1;

            for (int j = n; j >= i + 1; j--) {
                child[j + 1] = child[j];
            }

            child[i + 1] = z;

            for (int j = n - 1; j >= i; j--) {
                keys[j + 1] = keys[j];
            }

            keys[i] = y.keys[m - 1];
            n++;
        }
    }

    public Node search(int key) {
        int i = 0;

        while (i < n && key > keys[i]) {
                i++;
        }

        // If the key is found at this node, return this node
        if (i < n && keys[i] == key) {
                return this;
        }

        if (isLeaf) {
                return null;
        }

        return child[i].search(key);
 }

    private Node root;
    private int m;


    public BTree(int m) {
        this.root = null;
        this.m = m;
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(m, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * m - 1) {
                Node s = new Node(m, false);
                s.child[0] = root;
                s.splitChild(0, root);
                int i = (s.keys[0] < key) ? 1 : 0;
                s.child[i].insertNonFull(key);
                root = s;
            } else {
                root.insertNonFull(key);
            }
        }
    }

    public Node search(int key) {
        if (root == null) {
            return null;
        }
        return root.search(key);
    }


}
