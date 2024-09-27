class NumbersThread extends Thread {

    int from;
    int to;

    public NumbersThread(int from, int to) {
        // implement the constructor
        super();
        this.from = from;
        this.to = to;
    }

    // you should override some method here
    @Override
    public void run() {
        while (from <= to) {
            System.out.println(from);
            from++;
        }
    }
}