package majgenrelativity.forcelasers.tileEntities;

import majgenrelativity.forcelasers.MainFile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;



public class ion_Creater_Tile_Entity extends TileEntity implements IInventory, IUpdatePlayerListBox {
	// variable used to store ions across all blocks, items, etc.
	
	public int force_lasers_ions = 0;
	private boolean do_detect_tanks = true;
	private ion_Tank_Tile_Entity tank1, tank2, tank3, tank4, tank5, tank6;
	private ItemStack[] inv;
	private double coal_left = 0;
	@Override
	public String getName() {
		
		return("ion_creater");
	}

		
	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
		
		return new ChatComponentText("ion_creater");
	}

	@Override
	public int getSizeInventory() {
		
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		
		return inv[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		
		ItemStack stack = getStackInSlot(slot);
        if(stack != null){
            if(stack.stackSize <= amt){
                setInventorySlotContents(slot, null);
            }else{
                stack = stack.splitStack(amt);
                if(stack.stackSize == 0){
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {

		ItemStack stack = getStackInSlot(slot);
		if(stack != null) {
			setInventorySlotContents(slot, null);
		
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		// TODO Auto-generated method stub
		inv[slot] = stack;
		         if(stack != null && stack.stackSize > getInventoryStackLimit()){
		            stack.stackSize = getInventoryStackLimit();
		        }
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	     public boolean isUseableByPlayer(EntityPlayer player) {
	        return worldObj.getTileEntity(getPos()) == this &&
	                player.getDistanceSq(getPos().getX() + 0.5, getPos().getY() + 0.5, getPos().getZ() + 0.5) < 64;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack itemstack) {
		
		return !(itemstack.getItem() instanceof ItemCoal); // false is valid, true is invalid
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < inv.length; ++i) {  inv[i] = null;  }
		
	}
	 @Override
	    public void readFromNBT(NBTTagCompound tagCompound){
	        super.readFromNBT(tagCompound);
	        NBTTagList tagList = tagCompound.getTagList("Inventory", tagCompound.getId());
	        for(int i = 0; i < tagList.tagCount(); i++){
	            NBTTagCompound tag = tagList.getCompoundTagAt(i);
	            byte slot = tag.getByte("Slot");
	            if(slot >= 0 && slot < inv.length){
	                inv[slot] = ItemStack.loadItemStackFromNBT(tag);
	            }
	        }
	        this.force_lasers_ions = tagCompound.getInteger("IonCount");
	    }

	    @Override
	    public void writeToNBT(NBTTagCompound tagCompound){
	        super.writeToNBT(tagCompound);

	        NBTTagList itemList = new NBTTagList();
	        for(int i = 0; i < inv.length; i++){
	            ItemStack stack = inv[i];
	            if(stack != null){
	                NBTTagCompound tag = new NBTTagCompound();
	                tag.setByte("Slot", (byte) i);
	                stack.writeToNBT(tag);
	                itemList.appendTag(tag);
	            }
	            
	        }
	        tagCompound.setTag("Inventory", itemList);
	        
            tagCompound.setInteger("IonCount", force_lasers_ions);
	    }
public ion_Creater_Tile_Entity() {
	inv = new ItemStack[1];
	
}


@Override
public void update() {
        // Generate ions whenever loaded and there is coal in the slot
        if (force_lasers_ions<100) {
                if (coal_left==0) {
                        if (getStackInSlot(0)!=null) {
                                decrStackSize(0, 1);
                                coal_left=20;
                        }
                }
                if(coal_left>0){
                        force_lasers_ions+=1;
                        coal_left-=1;
                }
        }
 // detect adjacent ion tanks when the Ion Creator is first placed
        if (do_detect_tanks== true) {
                if(worldObj.getTileEntity(getPos().down()) != null) {
                if(worldObj.getTileEntity(this.getPos().down()) instanceof ion_Tank_Tile_Entity) {
                         tank1=((ion_Tank_Tile_Entity)worldObj.getTileEntity(this.getPos().down()));
                        // MainFile.logger.info(worldObj.getTileEntity(this.getPos().down()).getBlockType().getUnlocalizedName());
                        }
                }
                if(worldObj.getTileEntity(getPos().east()) != null) {
                    if(worldObj.getTileEntity(this.getPos().east()) instanceof ion_Tank_Tile_Entity) {
                       tank2=((ion_Tank_Tile_Entity)worldObj.getTileEntity(this.getPos().east())); 
                }
                }
                if(worldObj.getTileEntity(getPos().west()) != null) {
                    if(worldObj.getTileEntity(this.getPos().west()) instanceof ion_Tank_Tile_Entity) {
                       tank3=((ion_Tank_Tile_Entity)worldObj.getTileEntity(this.getPos().west())); 
                }
                }
                if(worldObj.getTileEntity(getPos().south()) != null) {
                    if(worldObj.getTileEntity(this.getPos().south()) instanceof ion_Tank_Tile_Entity) {
                       tank4=((ion_Tank_Tile_Entity)worldObj.getTileEntity(this.getPos().south())); 
                }
                }
                if(worldObj.getTileEntity(getPos().north()) != null) {
                    if(worldObj.getTileEntity(this.getPos().north()) instanceof ion_Tank_Tile_Entity) {
                       tank5=((ion_Tank_Tile_Entity)worldObj.getTileEntity(this.getPos().north())); 
                }
                }
                if(worldObj.getTileEntity(getPos().up()) != null) {
                    if(worldObj.getTileEntity(this.getPos().up()) instanceof ion_Tank_Tile_Entity) {
                       tank6=((ion_Tank_Tile_Entity)worldObj.getTileEntity(this.getPos().up())); 
                }
                }
                do_detect_tanks=false;
        }
        // these methods transfer ions out of the creator and into adjacent tanks if they have room
        if (tank1 != null && this.force_lasers_ions>0) {
        	if (tank1.getIons()<100) {
                tank1.pushIons(1);
        	this.force_lasers_ions-=1; }
        	//MainFile.logger.info(tank1.getIons()); }
        }
        if (tank2 != null && this.force_lasers_ions>0) {
        	if (tank2.getIons()<100) {
        	tank2.pushIons(1);
        	this.force_lasers_ions-=1; }
        }
        if (tank3 != null && this.force_lasers_ions>0) {
        	if (tank3.getIons()<100) {
        	tank3.pushIons(1);
        	this.force_lasers_ions-=1; }
        }
        if (tank4 != null && this.force_lasers_ions>0) {
        	if (tank4.getIons()<100) {
        	tank4.pushIons(1);
        	this.force_lasers_ions-=1; }
        }
        if (tank5 != null && this.force_lasers_ions>0) {
        	if (tank5.getIons()<100) {
        	tank5.pushIons(1);
        	this.force_lasers_ions-=1; }
        }
        if (tank6 != null && this.force_lasers_ions>0) { 
        	if (tank6.getIons()<100) {
        	tank6.pushIons(1);
        	this.force_lasers_ions-=1; }
        }
}
public int getIons() {
        return force_lasers_ions;
}
public void setIons(int ions) {
        force_lasers_ions=ions;
}
}
