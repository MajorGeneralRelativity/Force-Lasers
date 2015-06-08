package majgenrelativity.forcelasers.blocks;

import java.util.Random;

import majgenrelativity.forcelasers.MainFile;
import majgenrelativity.forcelasers.alltheguis.GUIs;
import majgenrelativity.forcelasers.tileEntities.ion_Tank_Tile_Entity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class Force_Field_Emitter extends BlockContainer implements ITileEntityProvider{
	public Force_Field_Emitter() {
		super(Material.iron);
		// GameRegistry.registerBlock(this, "ion_creater");
		setUnlocalizedName("force_lasers_field_emitter");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		}
		@Override
		public TileEntity createNewTileEntity(World world, int metadata){
			return new ion_Tank_Tile_Entity();
		}
		// Default render type for BlockContainer is -1 (don't render), change to render
			@Override
			public int getRenderType() {
				return 3;
			}
		//On right click open the GUI (only on the server side and if the player isn't sneaking)
		@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing facing, float hitX, float hitY, float hitZ) {
	        if(!world.isRemote) {
	            if (world.getTileEntity(pos) != null && !player.isSneaking())
	                player.openGui(MainFile.instance, GUIs.FORCE_LASERS_FIELD_EMITTER_GUI.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
	            return true;
	        }
	        return true;
	    }
		//If the block gets broken, drop all items on the floor
		@Override
		    public void breakBlock(World world, BlockPos pos, IBlockState state) {
		        dropItems(world, pos);
		        
		        super.breakBlock(world, pos, state);
		    }
		//randomly drop the items around the block
		private void dropItems(World world, BlockPos pos){
		    Random rand = new Random();

		    TileEntity tileEntity = world.getTileEntity(pos);
		    if (!(tileEntity instanceof IInventory)) {
		        return;
		    }
		    IInventory inventory = (IInventory) tileEntity;

		    for (int i = 0; i < inventory.getSizeInventory(); i++) {
		        ItemStack item = inventory.getStackInSlot(i);

		        if (item != null && item.stackSize > 0) {
		            float rx = rand.nextFloat() * 0.8F + 0.1F;
		            float ry = rand.nextFloat() * 0.8F + 0.1F;
		            float rz = rand.nextFloat() * 0.8F + 0.1F;

		            EntityItem entityItem = new EntityItem(world,
		                    pos.getX() + rx, pos.getY() + ry, pos.getZ() + rz,
		                    new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

		            if (item.hasTagCompound()) {
		                entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
		            }

		            float factor = 0.05F;
		            entityItem.motionX = rand.nextGaussian() * factor;
		            entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
		            entityItem.motionZ = rand.nextGaussian() * factor;
		            world.spawnEntityInWorld(entityItem);
		            item.stackSize = 0;
		        }
		    }
		}
}
