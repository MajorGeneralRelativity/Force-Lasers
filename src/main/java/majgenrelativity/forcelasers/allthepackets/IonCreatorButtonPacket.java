package majgenrelativity.forcelasers.allthepackets;

import io.netty.buffer.ByteBuf;
import majgenrelativity.forcelasers.MainFile;
import majgenrelativity.forcelasers.allthecontainers.IonCreaterContainer;
import majgenrelativity.forcelasers.tileEntities.ion_Creater_Tile_Entity;
import majgenrelativity.forcelasers.tileEntities.ion_Tank_Tile_Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class IonCreatorButtonPacket implements IMessage{
	
	private BlockPos pos;
	private int dimID, index1, index2, index3, index4;
	private String posX, posY, posZ, dimIDString, incomingString;
	private ion_Creater_Tile_Entity tileEntity;
	public IonCreatorButtonPacket() {}
	
	
	public IonCreatorButtonPacket(BlockPos pos, int dimID) {
		this.pos=pos;
		this.dimID=dimID;
	}
	
	@Override
    public void fromBytes(ByteBuf buf) {
        incomingString = ByteBufUtils.readUTF8String(buf); // this class is very useful in general for writing more complex objects
        index1=(incomingString.indexOf("|"))-1; // get the index of the first dividing marker, and then subtract 1 to get the last index of the pos x, same with the methods below
        posX=incomingString.substring(0, index1); // get the pos and dimID of the serialized blockpos and dimID
        index2=(incomingString.indexOf("|", index1+1))-1;
        posY=incomingString.substring(index1, index2);
        index3=(incomingString.indexOf("|", index2+1))-1;
        posZ=incomingString.substring(index2, index3);
        index4=(incomingString.indexOf("|", index3+1))-1;
        dimIDString=incomingString.substring(index3, index4);
        pos=pos.multiply(0);
        pos.east(Integer.parseInt(posX));
        pos.up(Integer.parseInt(posY));
        pos.south(Integer.parseInt(posZ));	
	}
	
	@Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf,  pos.getX() + "|" + pos.getY() + "|" + pos.getX() + "|" + dimID);
    }
	
public static class Handler implements IMessageHandler<IonCreatorButtonPacket, IMessage> {
        private ion_Creater_Tile_Entity tileEntity;
        private BlockPos pos;
        
        @Override
        public IMessage onMessage(IonCreatorButtonPacket message, MessageContext ctx) {
        	
        	MainFile.logger.info("packet received");
        	
            
            return null; // no response in this case
        }

	       
    }
}
