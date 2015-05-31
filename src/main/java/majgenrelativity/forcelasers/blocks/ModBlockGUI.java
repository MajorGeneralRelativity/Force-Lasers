package majgenrelativity.forcelasers.blocks;

// this is the block class, not the container class
import majgenrelativity.forcelasers.MainFile;
import majgenrelativity.forcelasers.alltheguis.GUIs;
import majgenrelativity.forcelasers.tileEntities.ion_Creater_Tile_Entity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlockGUI extends BlockContainer implements ITileEntityProvider{
	public ModBlockGUI() {
		super(Material.iron);
		// GameRegistry.registerBlock(this, "ion_creater");
		setUnlocalizedName("ion_creater");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int metadata){
		return new ion_Creater_Tile_Entity();
	}
	
	//On right click open the GUI (only on the server side and if the player isn't sneaking)
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!world.isRemote) {
            if (world.getTileEntity(pos) != null && !player.isSneaking())
                player.openGui(MainFile.instance, GUIs.ION_CREATER_GUI.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
        return true;
    }

	// Default render type for BlockContainer is -1 (don't render), change to render
	@Override
	public int getRenderType() {
		return 3;
	}
}
