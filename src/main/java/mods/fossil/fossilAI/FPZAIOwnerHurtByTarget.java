package mods.fossil.fossilAI;

import mods.fossil.entity.mob.EntityFriendlyPigZombie;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class FPZAIOwnerHurtByTarget extends EntityAITarget
{
    EntityFriendlyPigZombie fpz;
    EntityLivingBase field_48393_b;

    public FPZAIOwnerHurtByTarget(EntityFriendlyPigZombie var1)
    {
        super(var1, false);
        this.fpz = var1;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.fpz.isTamed())
        {
            return false;
        }
        else
        {
            EntityLivingBase var1 = this.fpz.func_130012_q();

            if (var1 == null)
            {
                return false;
            }
            else
            {
                this.field_48393_b = var1.getAITarget();
                return this.isSuitableTarget(this.field_48393_b, false);
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.field_48393_b);
        super.startExecuting();
    }
}
