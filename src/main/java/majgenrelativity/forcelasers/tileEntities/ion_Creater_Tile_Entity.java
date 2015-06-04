package majgenrelativity.forcelasers.tileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;



public class ion_Creater_Tile_Entity extends TileEntity implements IInventory, IUpdatePlayerListBox {
	// variable used to store ions across all blocks, items, etc.
	
	public int force_lasers_ions = 0;
	
	private ItemStack[] inv;
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
	// Generate ions whenever loaded
	if (force_lasers_ions<100) 
	{
	force_lasers_ions+=1;
	}
}
public int getIons() {
	return force_lasers_ions;
}
public void setIons(int ions) {
	force_lasers_ions=ions;
}
}
