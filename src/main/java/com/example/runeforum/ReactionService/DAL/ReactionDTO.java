package com.example.runeforum.ReactionService.DAL;

import com.example.runeforum.ReactionService.Logic.ReactionModel;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter @Setter
public class ReactionDTO
{
   private long ID;
   private String Text;
   private ZonedDateTime Date;

   public ReactionDTO(ReactionModel reactionModel)
   {
      this.ID = reactionModel.getID();
      Text = reactionModel.getText();
      Date = reactionModel.getDate();
   }
}
