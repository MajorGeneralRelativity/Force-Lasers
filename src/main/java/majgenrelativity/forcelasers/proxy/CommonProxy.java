package majgenrelativity.forcelasers.proxy;

import majgenrelativity.forcelasers.tileEntities.Force_Lasers_Field_Emitter_Tile_Entity;
import majgenrelativity.forcelasers.tileEntities.ion_Creater_Tile_Entity;
import majgenrelativity.forcelasers.tileEntities.ion_Tank_Tile_Entity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
public void registerRenders() {
}
	 public void registerTileEntities(){
		 GameRegistry.registerTileEntity(ion_Creater_Tile_Entity.class, "ion_creater");
		 GameRegistry.registerTileEntity(ion_Tank_Tile_Entity.class, "ion_tank");
		 GameRegistry.registerTileEntity(Force_Lasers_Field_Emitter_Tile_Entity.class, "force_lasers_field_emitter");
		 }
}
