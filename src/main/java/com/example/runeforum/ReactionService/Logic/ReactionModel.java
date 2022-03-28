package com.example.runeforum.ReactionService.Logic;

import com.example.runeforum.ReactionService.API.ReactionViewModel;
import com.example.runeforum.ReactionService.DAL.ReactionDTO;
import com.example.runeforum.ReactionService.DAL.ReactionEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter @Setter
public class ReactionModel
{
    private long ID;
    private String Text;
    private ZonedDateTime Date;

    public ReactionModel(ReactionDTO reactionDTO)
    {
        this.ID = reactionDTO.getID();
        Text = reactionDTO.getText();
        Date = reactionDTO.getDate();
    }

    public ReactionModel(ReactionEntity reactionEntity)
    {
        this.ID = reactionEntity.getID();
        Text = reactionEntity.getText();
        Date = reactionEntity.getDate();
    }

    public ReactionModel(ReactionViewModel reactionViewModel)
    {
        this.ID = reactionViewModel.getID();
        Text = reactionViewModel.getText();
        Date = reactionViewModel.getDate();
    }
}
