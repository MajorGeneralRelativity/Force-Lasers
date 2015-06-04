package majgenrelativity.forcelasers.alltheguis;

import majgenrelativity.forcelasers.MainFile;
import majgenrelativity.forcelasers.allthecontainers.IonCreaterContainer;
import majgenrelativity.forcelasers.tileEntities.ion_Creater_Tile_Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{

	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if(tileEntity instanceof ion_Creater_Tile_Entity){  //If The TileEntity is a Laser, open the Laser GUI (Server side)
            return new IonCreaterContainer(player.inventory, (ion_Creater_Tile_Entity) tileEntity);
            
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if(tileEntity instanceof ion_Creater_Tile_Entity){  //If The TileEntity is a Laser, open the Laser GUI (Client side)
            return new IonCreaterGUI(player.inventory, (ion_Creater_Tile_Entity) tileEntity);
        }
        return null;
    }

    //Register all GUIs (has to be called during FML Init)
    public static void init(){
        NetworkRegistry.INSTANCE.registerGuiHandler(MainFile.instance, new GuiHandler());
    }
}