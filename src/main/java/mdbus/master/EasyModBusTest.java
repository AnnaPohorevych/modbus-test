package mdbus.master;

import de.re.easymodbus.modbusclient.ModbusClient;

public class EasyModBusTest {

    public static void main(String[] args){
        ModbusClient modbusClient = new ModbusClient("127.0.0.1", 502);
        modbusClient.setConnectionTimeout(10000);
        try
        {
            modbusClient.Connect();
            boolean[] bitArray = new boolean[5];
            for (int i = 0; i < 5; i++) {
                bitArray[i] = false;
            }
            modbusClient.WriteMultipleCoils(0, bitArray);
            modbusClient.WriteSingleCoil(16, false);
            boolean[] result = modbusClient.ReadCoils(0, 5);
            System.out.println("Coil values " + result[0] + "," + result[1] + "," + result[2] + "," + result[3] +  "," + result[4]);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
