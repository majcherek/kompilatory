package client;

import MiddlewareTestbed.ItemPrx;

public class Client {
	 ItemPrx itemPrx; 
	
    public static void main(String[] args)
    {
    	System.out.println("start");
        int status = 0;
        Ice.Communicator ic = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("hello:default -p 10000");
            MiddlewareTestbed.AFactoryPrx printer = MiddlewareTestbed.AFactoryPrxHelper.checkedCast(base);
            if (printer == null)
                throw new Error("Invalid proxy");

            ItemPrx itemPrx = printer.createItem("obiekcik", "ItemA");
            System.out.println("pobralam " + itemPrx.getName());

        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (ic != null) {
            // Clean up
            //
            try {
                ic.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
        System.exit(status);
    }
}