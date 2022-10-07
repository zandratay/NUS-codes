abstract class Host {

    private final ImList<Term> TerminalList;

    //Host(ImList<Term> TerminalList) {
    //    this.TerminalList = new ImList<Term>();
    //}

    Host() {
        this.TerminalList = new ImList<Term>();
    }

    public ImList<Term> getList() {
        return this.TerminalList;
    }

    abstract String getID();

    abstract boolean equals(Host h1);

    //abstract Term getTerm();

    public void broadcast() {
        ImList<Term> terminalList = this.getList();
        //ImList<Broadcaster> broadcastList = new ImList<Broadcaster>();
        if (terminalList.size() != 0) {
            String str = new String();
            for (int i = 0; i < terminalList.size(); i++) {
                //broadcastList = broadcastList.add(new Broadcaster(terminalList.get(i)));
                System.out.println(terminalList.get(i).toString() + ":beep");
            }
        }
    }

    @Override
    public String toString() {
        return "placeholder";
    }

}
