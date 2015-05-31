package majgenrelativity.forcelasers.proxy;

import majgenrelativity.forcelasers.init.ForceLasersBlocks;
import majgenrelativity.forcelasers.init.ForceLasersItems;

public class ClientProxy extends CommonProxy{
	@Override	
	public void registerRenders() {
		ForceLasersItems.registerRenders();
		ForceLasersBlocks.registerRenders();
	}
}
