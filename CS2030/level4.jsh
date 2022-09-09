void serveCruises(List<Cruise> cruises, int numOfLoaders) {
    Loader l1 = new Loader(numOfLoaders);
    
    if (numOfLoaders == 1) {
        for (Cruise cruise : cruises) {
            Cruise c = cruise;

            int arrTime = c.getArrivalTime();
            int loadersReq = c.getNumOfLoadersRequired();
            int svcTime = c.getServiceTime();
            int time = arrTime;

            System.out.println(new Service(l1, c, arrTime));

            for (int i = 0; i < loadersReq - 1; i++) {
                l1 = l1.nextLoader();
                time = time + svcTime;
                System.out.println(new Service(l1, c, time));
            }
        }
    } else {
        for (Cruise cruise : cruises) {
            Cruise c = cruise;
            
            int arrTime = c.getArrivalTime();
            int loadersReq = c.getNumOfLoadersRequired();
            int svcTime = c.getServiceTime();

            for (int j = 0; j < loadersReq; j++) {
                l1 = l1.nextLoader();
                System.out.println(new Service(l1.prevLoader(), c, arrTime));
            }
        }
    }
}
