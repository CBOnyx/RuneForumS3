package com.example.runeforum.ReactionService.API;

import com.example.runeforum.ReactionService.Logic.ReactionModel;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter @Setter
public class ReactionViewModel
{
    private int ID;
    private String Text;
    private ZonedDateTime Date;

    public ReactionViewModel(ReactionModel reactionModel)
    {
        this.ID = reactionModel.getID();
        Text = reactionModel.getText();
        Date = reactionModel.getDate();
    }
}
