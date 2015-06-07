package majgenrelativity.forcelasers.proxy;

import majgenrelativity.forcelasers.tileEntities.ion_Creater_Tile_Entity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
public void registerRenders() {
}
	 public void registerTileEntities(){
		 GameRegistry.registerTileEntity(ion_Creater_Tile_Entity.class, "ion_creater");
		 GameRegistry.registerTileEntity(ion_Creater_Tile_Entity.class, "ion_tank");
		 }
}
