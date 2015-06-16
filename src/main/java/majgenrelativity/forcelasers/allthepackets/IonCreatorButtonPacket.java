package majgenrelativity.forcelasers.allthepackets;

import io.netty.buffer.ByteBuf;
import majgenrelativity.forcelasers.allthecontainers.IonCreaterContainer;
import majgenrelativity.forcelasers.tileEntities.ion_Creater_Tile_Entity;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class IonCreatorButtonPacket implements IMessage{
	private String text = "dave";
	
	public IonCreatorButtonPacket() {}
	
	public IonCreatorButtonPacket(String text) {
		this.text=text;
	}
	
	@Override
    public void fromBytes(ByteBuf buf) {
        text = ByteBufUtils.readUTF8String(buf); // this class is very useful in general for writing more complex objects
    }
	
	@Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, text);
    }
	
public static class Handler implements IMessageHandler<IonCreatorButtonPacket, IMessage> {
        private ion_Creater_Tile_Entity tileEntity;
        private BlockPos pos;
        @Override
        public IMessage onMessage(IonCreatorButtonPacket message, MessageContext ctx) {
            System.out.println(String.format("Received %s from %s", message.text, ctx.getServerHandler().playerEntity.getDisplayName()));
            
            return null; // no response in this case
        }

	       
    }
}
