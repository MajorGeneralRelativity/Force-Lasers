package majgenrelativity.forcelasers.allthecontainers;


import majgenrelativity.forcelasers.tileEntities.Force_Lasers_Field_Emitter_Tile_Entity;
import majgenrelativity.forcelasers.tileEntities.ion_Creater_Tile_Entity;
import majgenrelativity.forcelasers.tileEntities.ion_Tank_Tile_Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ForceFieldEmitterContainer extends Container{
	protected Force_Lasers_Field_Emitter_Tile_Entity tileEntity;
	@Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);

        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            //Item is in Container. Transfer to Player inventory
            if (slot < tileEntity.getSizeInventory()) {
                if (!this.mergeItemStack(stackInSlot, tileEntity.getSizeInventory(), 36+tileEntity.getSizeInventory(), true)) {
                    return null;
                }
            }
            //Item is in Player inventory. Transfer into container
            //TODO Shift-click deletes all items over containers maximum stack size
            else if (!this.mergeItemStack(stackInSlot, 0, tileEntity.getSizeInventory(), false)) {
                return null;
            }

            if (stackInSlot.stackSize == 0) {
                slotObject.putStack(null);
            } else {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize) {
                return null;
            }
            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return tileEntity.isUseableByPlayer(player);
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
    	        for (int i = 0; i < 3; i++) {
    	           for (int j = 0; j < 9; j++) {
    	                 addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
    	                       8 + j * 18, 92 + i * 18));
    	        }
    	      }
    	     for (int i = 0; i < 9; i++) {
    	            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 150));
    	        }
    }
    public void detectAndSendChanges() {
    	 super.detectAndSendChanges();

    	    for (int i = 0; i < this.crafters.size(); ++i)
    	         {
    	          ICrafting icrafting = (ICrafting)this.crafters.get(i);

    	            
    	           icrafting.sendProgressBarUpdate(this, 1323, this.tileEntity.getIons());
    	            
    	         }

    	         
    }
    	     @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int ions)
    	     {
    	         this.tileEntity.setIons(ions);
    	     }
    public ForceFieldEmitterContainer(InventoryPlayer inventoryPlayer, Force_Lasers_Field_Emitter_Tile_Entity tileEntity){
        this.tileEntity = tileEntity;
        addSlotToContainer(new Slot(tileEntity, 0, 33, 18));
        this.bindPlayerInventory(inventoryPlayer);
    }

}
