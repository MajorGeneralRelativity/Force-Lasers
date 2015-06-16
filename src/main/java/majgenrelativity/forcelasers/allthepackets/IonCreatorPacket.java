package majgenrelativity.forcelasers.allthepackets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class IonCreatorPacket implements IMessageHandler<SimpleMessage, IMessage>
{
  @Override
	public IMessage onMessage(SimpleMessage message, MessageContext ctx)
	{
	  // just to make sure that the side is correct
	  if (ctx.side.isClient())
	  {
	    
	    boolean bool = message.activationBool;
	  }
	}
  
  public static class SimpleMessage implements IMessage
  {
    
    private boolean activationBool;
    
    // this constructor is required otherwise you'll get errors (used somewhere in fml through reflection)
    public SimpleMessage() {}
    
    public SimpleMessage(int simpleInt, boolean activationBool)
    {
      
      this.activationBool = activationBool;
    }
    
    @Override
    public void fromBytes(ByteBuf buf)
    {
      // the order is important
      
      this.activationBool = buf.readBoolean();
    }
    
    @Override
    public void toBytes(ByteBuf buf)
    {
      
      buf.writeBoolean(activationBool);
    }
  }

@Override
public IMessage onMessage(
		majgenrelativity.forcelasers.allthepackets.SimpleMessage message,
		MessageContext ctx) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public IMessage onMessage(
		majgenrelativity.forcelasers.allthepackets.SimpleMessage message,
		MessageContext ctx) {
	// TODO Auto-generated method stub
	return null;
}
}