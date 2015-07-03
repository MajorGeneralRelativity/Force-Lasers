package majgenrelativity.forcelasers.allthepackets;



import java.lang.reflect.Array;
import java.util.Arrays;

import io.netty.buffer.ByteBuf;
import majgenrelativity.forcelasers.MainFile;
import majgenrelativity.forcelasers.tileEntities.ion_Creater_Tile_Entity;
import net.minecraft.util.BlockPos;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class IonCreatorButtonPacket implements IMessage{
	
	private BlockPos pos;
	private int dimID, index1, index2, index3, index4;
	private String dimIDString, incomingString;
	private ion_Creater_Tile_Entity tileEntity;
	public IonCreatorButtonPacket() {}
	
	
	public IonCreatorButtonPacket(BlockPos pos, int dimID) {
		this.pos=pos;
		this.dimID=dimID;
	}
	
	@Override
    public void fromBytes(ByteBuf buf) {
		
		incomingString = ByteBufUtils.readUTF8String(buf); // this class is very useful in general for writing more complex objects
		String[] parts = incomingString.split("\\|");
		MainFile.logger.info(incomingString);
		Arrays.asList(parts).stream().forEach(s -> System.out.println(s));
		pos = new BlockPos(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
		dimID = Integer.parseInt(parts[3]);
        tileEntity=((ion_Creater_Tile_Entity)DimensionManager.getWorld(dimID).getTileEntity(pos));
        MainFile.logger.info(pos);
        MainFile.logger.info(tileEntity);
        tileEntity.changeActiveBoolean();
	}
	
	@Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, pos.getX() + "|" + pos.getY() + "|" + pos.getZ() + "|" + dimID);
    }
	
public static class Handler implements IMessageHandler<IonCreatorButtonPacket, IMessage> {
                
        @Override
        public IMessage onMessage(IonCreatorButtonPacket message, MessageContext ctx) {
        	
        	MainFile.logger.info("packet received");
        	
        	
            
            return null; // no response in this case
        }

	       
    }
}
