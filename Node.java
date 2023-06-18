public class Node {
    private Tovar tovar ;
    private Node leftChild;
    private Node rightChild;

    public void printNode() {
        System.out.println("Chosen NODE has value: " + tovar.toString());
    }

    public Tovar getValue() {
        return this.tovar;
    }

    public String getStringValue() {
        return tovar.toString();
    }

    public void setValue(final Tovar tovar) {
        this.tovar = tovar;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }


}