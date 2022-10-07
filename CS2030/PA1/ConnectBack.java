class ConnectBack extends Host {

    private final String id;
    private final Term h1;
    private final Term ogTerm;
    private final Host ogHost;
    //private final Transmitter ogHost;
    private final String cmd;
    //private final ImList<Term> TerminalList;
    
    /*
    ConnectBack(ImList<Term> TerminalList, String id, Term h1, Term ogTerm, Host ogHost, String cmd) {
        super(TerminalList);
        //this.TerminalList = new ImList<Term>();
        this.id = id;
        this.h1 = h1;
        this.ogTerm = ogTerm;
        this.ogHost = ogHost;
        this.cmd = cmd;
        //this.TerminalList = TerminalList;
    }
    */

    ConnectBack(String id, Term h1, Term ogTerm, Host ogHost, String cmd) {
        super();
        //this.TerminalList = new ImList<Term>();
        this.id = id;
        this.h1 = h1;
        this.ogTerm = ogTerm;
        this.ogHost = ogHost;
        this.cmd = cmd;
        //this.TerminalList = TerminalList;
    }

    @Override
    public ImList<Term> getList() {
        ImList<Term> temp = super.getList();
        return temp.add(ogTerm);
    //    return temp.add(ogTerm);
    }

    public Term getH1() {
        return this.h1;
    }

    @Override
    public boolean equals(Host h1) {
        //return this.ogHost.toString().compareTo(h1) == 0 ? true : false;
        return ogHost.equals(h1);
    }

    @Override
    public String getID() {
        return this.ogHost.getID();
    }

    @Override
    public String toString() {
        return this.getH1().toString() + " >--ack--> " + this.ogHost.getID();
    }
}


