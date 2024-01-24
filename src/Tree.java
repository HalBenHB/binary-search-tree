import java.util.ArrayList;

public class Tree {

    final static int LEFT = 0;
    final static int RIGHT = 1;

    protected TreeNode root;

    public Tree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode recursiveSearch(int value) {
        if (root != null) {
            return root.recursiveSearch(value);
        } else {
            return null;
        }
    }

    public TreeNode iterativeSearch(int value) {
        TreeNode tmp = root;
        while (tmp != null) {
            if (value < (int) tmp.getData()) {
                tmp = tmp.getLeft();
            } else {
                if (value > (int) tmp.getData()) {
                    tmp = tmp.getRight();
                } else {
                    return tmp;
                }
            }
        }
        return null;
    }

    public TreeNode iterativeMinSearch() {
        TreeNode tmp = root;
        TreeNode parent = null;
        while (tmp != null) {
            parent = tmp;
            tmp = tmp.getLeft();
        }
        return parent;
    }

    public TreeNode iterativeMaxSearch() {
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.getRight() == null) {
                return tmp;
            }
            tmp = tmp.getRight();
        }
        return null;
    }

    public TreeNode recursiveMinSearch() {
        if (root != null) {
            return root.recursiveMinSearch();
        }
        return null;
    }

    public TreeNode recursiveMaxSearch() {
        if (root != null) {
            return root.recursiveMaxSearch();
        }
        return null;
    }

    protected TreeNode getParent(TreeNode node) {
        TreeNode x = root, parent = null;
        while (x != node) {
            parent = x;

            if (isString(node.data)) {
                if (((String) x.data).compareTo((String) node.data) > 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }

            } else if (isInteger(node.data)) {
                if ((int) x.data > (int) node.data) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        return parent;
    }

    public void delete(int value) {

        // TreeNode y, x = root, parent; //UGLY CODE
        TreeNode y;
        TreeNode x = root;
        TreeNode parent;

        while ((int) x.data != (int) value) {
            if ((int) x.data > (int) value) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        parent = getParent(x);
        while (true) {
            if (x.left != null) {
                y = x.left.recursiveMaxSearch();
                parent = getParent(y);
            } else {
                if (x.right != null) {
                    y = x.right.recursiveMinSearch();
                    parent = getParent(y);
                } else {
                    if (parent == null) {
                        root = null;
                    } else {
                        if (parent.left == x) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    }
                    break;
                }
            }
            x.data = y.data;
            x = y;
        }
    }

    public void delete2(Object value) {
        // TreeNode y, x = root, parent; //UGLY CODE
        TreeNode y;
        TreeNode x = root;
        TreeNode parent;
        // System.out.println((String) x.data + value + (x.data.equals(value)));

        if (isString(value)) {
            // System.out.println("Search started Searching:" + value + " Current: " +
            // x.data);
            while (!x.data.equals(value)) {
                if (((String) value).compareTo((String) x.data) < 0) {
                    x = x.left;
                    // System.out.println("Going left. Current: "+ x.data);
                    // System.out.println((String) x.data + value + (x.data==value));
                } else {
                    x = x.right;
                    // System.out.println("Going right. Current: "+ x.data);
                }
            }
        } else {
            while ((int) x.data != (int) value) {
                if ((int) x.data > (int) value) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }

        parent = getParent(x);
        while (true) {
            if (x.left != null) {
                y = x.left.recursiveMaxSearch();
                parent = getParent(y);
            } else {
                if (x.right != null) {
                    y = x.right.recursiveMinSearch();
                    parent = getParent(y);
                } else {
                    if (parent == null) {
                        root = null;
                    } else {
                        if (parent.left == x) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    }
                    break;
                }
            }
            x.data = y.data;
            x = y;
        }
    }

    public void inorder() {
        if (root != null) {
            root.inorder();
        }
    }

    public void preorder() {
        if (root != null) {
            root.preorder();
        }
    }

    public void postorder() {
        if (root != null) {
            root.postorder();
        }
    }

    protected void insertChild(TreeNode parent, TreeNode child) {
        if (parent == null) {
            root = child;
        } else {

            if (child.data instanceof String) {

                if (((String) child.getData()).compareTo((String) parent.getData()) < 0) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }

            } else {
                if ((int) child.data < (int) parent.data) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }

        }
    }

    public void iterativeInsert(TreeNode node) {
        TreeNode parent = null;
        TreeNode tmp = root;

        while (tmp != null) {
            parent = tmp;

            if (node.getData() instanceof String) {
                // System.out.println("1"+node.data);
                if (((String) node.getData()).compareTo((String) tmp.getData()) < 0) {
                    tmp = tmp.getLeft();
                } else {
                    tmp = tmp.getRight();
                }
            } else {
                // System.out.println("2"+node.data);
                if ((int) node.getData() < (int) tmp.getData()) {
                    tmp = tmp.getLeft();
                } else {
                    tmp = tmp.getRight();
                }
            }
        }
        insertChild(parent, node);
    }

    public void recursiveInsert(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.recursiveInsert(node);
        }
    }

    public void prettyPrint() {
        if (root != null) {
            root.prettyPrint(0);
        }
    }

    public int nodeCountWithStack() {
        TreeNode tmp;
        int count = 0;
        Stack c = new Stack(100);
        if (root != null) {
            c.push(new Element(root));
        }
        while (!c.isEmpty()) {
            Element e = c.pop();
            count++;
            tmp = e.getData();
            if (tmp.getLeft() != null) {
                c.push(new Element(tmp.getLeft()));
            }
            if (tmp.getRight() != null) {
                c.push(new Element(tmp.getRight()));
            }
        }
        return count;
    }

    public int nodeCountWithQueue() {
        TreeNode tmp;
        int count = 0;
        Queue c = new Queue(100);
        if (root != null) {
            c.enqueue(new Element(root));
        }
        while (!c.isEmpty()) {
            Element e = c.dequeue();
            count++;
            tmp = e.getData();
            if (tmp.getLeft() != null) {
                c.enqueue(new Element(tmp.getLeft()));
            }
            if (tmp.getRight() != null) {
                c.enqueue(new Element(tmp.getRight()));
            }
        }
        return count;
    }

    public TreeNode exactSearch(int search) {
        TreeNode result = root;

        while (result != null) {
            if ((int) result.data == search) {
                return result;
            } else if ((int) result.data > search) {
                result = result.left;
            } else if ((int) result.data < search) {
                result = result.right;
            }
        }
        return new TreeNode("null");
    }

    public TreeNode exactSearch(String search) {
        TreeNode result = root;

        while (result != null) {
            String value = (String)  result.data;
            if (value.compareTo(search) ==0) {
                return result;
            } else if (value.compareTo(search) > 0) {
                result = result.left;
            } else if (value.compareTo(search) < 0) {
                result = result.right;
            }
        }

        return new TreeNode("null");
    }

    public ArrayList<TreeNode> intervalSearch(int lower, int upper) {
        ArrayList<TreeNode> result = new ArrayList<>();
        intervalSearch(root, lower, upper, result);
        if(result.isEmpty()) result.add(new TreeNode("null"));
        return result;
    }

    public ArrayList<TreeNode> intervalSearch(String lower, String upper) {
        ArrayList<TreeNode> result = new ArrayList<>();
        intervalSearch(root, lower, upper, result);
        if(result.isEmpty()) result.add(new TreeNode("null"));
        return result;
    }

    private void intervalSearch(TreeNode node, int lower, int upper, ArrayList<TreeNode> result) {
        if (node != null) {
            int value = (int) node.getData();

            if (value > lower) {
                intervalSearch(node.getLeft(), lower, upper, result);
            }

            if (value >= lower && value <= upper) {
                result.add(node);
            }

            if (value < upper) {
                intervalSearch(node.getRight(), lower, upper, result);
            }
        }
    }

    private void intervalSearch(TreeNode node, String lower, String upper, ArrayList<TreeNode> result) {
        if (node != null) {
            String value = (String) node.getData();

            if (value.compareTo(lower) > 0) {
                intervalSearch(node.getLeft(), lower, upper, result);
            }

            if (value.compareTo(lower) >= 0 && value.compareTo(upper) <= 0) {
                result.add(node);
            }

            if (value.compareTo(upper) < 0) {
                intervalSearch(node.getRight(), lower, upper, result);
            }
        }
    }

    private boolean isString(Object o) {
        if (o instanceof String) {
            return true;
        }
        return false;
    }

    private boolean isInteger(Object o) {
        if (o instanceof Integer) {
            return true;
        }
        return false;
    }

}