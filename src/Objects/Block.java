package Objects;

public abstract class Block {
    public Block(int xOnFrame, int yOnFrame, String text) {
        this.xOnFrame = xOnFrame;
        this.yOnFrame = yOnFrame;
        this.text = text;
    }

    public int xOnFrame;
    public int yOnFrame;
    private int width = 100;
    private int height = 60;
    private String text;
    public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
