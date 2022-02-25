package com.example.runeforum.PostService.API;

import com.example.runeforum.PostService.Logic.PostModel;
import com.example.runeforum.ReactionService.API.ReactionViewModel;
import com.example.runeforum.ReactionService.Logic.ReactionModel;
import com.example.runeforum.ReactionService.ReactionListConverter;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter @Setter
public class PostViewModel
{
    private int ID;
    private String Title;
    private String Text;
    private ZonedDateTime Date;
    private List<ReactionViewModel> Reactions;

    public PostViewModel(PostModel postModel)
    {
        ReactionListConverter reactionListConverter = new ReactionListConverter();

        this.ID = postModel.getID();
        Title = postModel.getTitle();
        Text = postModel.getText();
        Date = postModel.getDate();
        Reactions = reactionListConverter.ReactionModelToReactionViewModel(postModel.getReactions());
    }
}
