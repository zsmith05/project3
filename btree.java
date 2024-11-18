public class btree {
    static class Product {
        String id;
        String name;
        String cat;
        String price;

        public Product(String id, String name, String cat, String price) {
            this.id = id;
            this.name = name;
            this.cat = cat;
            this.price = price;
        }

        public String toString() {
            return "Product id: "
                    + id +
                    ", Name= " + name + '\'' +
                    ", Category= " + cat + '\'' +
                    ", Price= " + price
                    ;
        }

    }
    private static class Node{
        int m;
        Node[] child;
        int n;
        boolean isLeaf;
        Product[] products;


        public Node(int m, boolean isLeaf){
            this.m = m;
            this.isLeaf = isLeaf;
            this.child = new Node[2 * m];
            this.n = 0;
            this.products = new Product[2 * m-1];
        }

        public void insertNonFull(Product product) {
            int i = n - 1;


            if (isLeaf) {
                // Find the correct location for the new product
                while (i >= 0 && product.id.compareTo(products[i].id) < 0) {
                    products[i + 1] = products[i];
                    i--;
                }

                products[i + 1] = product;
                n++;
            } else {



                    while (i >= 0  && product.id.compareTo(products[i].id) < 0) {
                        i--;
                    }

                    // Check if the found child is full
                    if (child[i + 1].n == 2 * m - 1) {
                        splitChild(i + 1, child[i + 1]);

                        if (product.id.compareTo(products[i + 1].id) > 0) {
                            i++;
                        }
                    }

                    child[i + 1].insertNonFull(product);


            }
        }
        public Product search(String product) {
            int i = 0;
            while (i < n && product.compareTo(products[i].id) > 0) {
                i++;
            }
            // If the key is found at this node, return this node
            if (i < n && products[i].id.equals(product)) {
                return products[i];
            }
            if (isLeaf) {
                return null;
            }
            return child[i].search(product);
        }

        public void splitChild(int i, Node y) {
            Node z = new Node(y.m, y.isLeaf);
            z.n = m - 1;

            for (int j = 0; j < m - 1; j++) {
                z.products[j] = y.products[j + m];
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
                products[j + 1] = products[j];
            }

            products[i] = y.products[m - 1];
            n++;
        }
    }

    private Node root;
    private int m;


    public btree(int m) {
        this.root = null;
        this.m = m;
    }

    public void insert(Product product) {
        boolean noDupe = true;

        if (search(product.id) != null) {
            System.out.println("A product with this ID already exists.");
            noDupe = false;
            return;
        }
        if(noDupe){
            if (root == null) {
                // Create the root if it doesn't exist
                root = new Node(m, true);
                root.products[0] = product;
                root.n = 1;
            } else {
                // If the root is full, split it
                if (root.n == 2 * m - 1) {
                    Node s = new Node(m, false);

                    s.child[0] = root;

                    // Split the old root
                    s.splitChild(0, root);

                    // Determine which child to insert the new product into
                    int i = (s.products[0].id.compareTo(product.id) < 0) ? 1 : 0;
                    s.child[i].insertNonFull(product);

                    // Update the root
                    root = s;
                } else {
                    root.insertNonFull(product);
                }
            }

        }
    }
    public Product search(String product) {
        if (root == null) {
            return null;
        }
        return root.search(product);
    }

    public void printTree() {
        if (root != null) {
            printTree(root, 0);
        } else {
            System.out.println("The tree is empty.");
        }
    }

    private void printTree(Node node, int level) {
        if (node != null) {
            // Print the current node's products
            System.out.print("Level " + level + ": ");
            for (int i = 0; i < node.n; i++) {
                System.out.print(node.products[i].id + " ");
            }
            System.out.println();

            // Recursively print all children
            if (!node.isLeaf) {
                for (int i = 0; i <= node.n; i++) {
                    printTree(node.child[i], level + 1);
                }
            }
        }
    }




}
