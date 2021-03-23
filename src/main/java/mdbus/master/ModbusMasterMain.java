package mdbus.master;

import com.ghgande.j2mod.modbus.facade.ModbusTCPMaster;
import com.ghgande.j2mod.modbus.util.BitVector;

public class ModbusMasterMain {

    public static void main(String[] args){
       ModbusTCPMaster master = null;
        try {
            master = new ModbusTCPMaster("127.0.0.1", 502);
            master.connect();
            BitVector values = new BitVector(5);
            for (int i = 0; i < 5; i++) {
                values.setBit(i, true);
            }
            master.writeMultipleCoils(0,values);
            master.writeCoil(16,true);
            BitVector result = master.readCoils(0, 5);
            System.out.println("Read coils - " + result.getBit(0) + "," + result.getBit(0) + "," +
                    result.getBit(0) + "," + result.getBit(0) +  "," + result.getBit(0));

        }
        catch (Exception e) {
            System.out.println("Failed test - " + e.getMessage());
        }
        finally {
            if (master != null) {
                master.disconnect();
            }
        }
    }
}
