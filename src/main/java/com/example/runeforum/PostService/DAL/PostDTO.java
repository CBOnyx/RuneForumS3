package com.example.runeforum.PostService.DAL;

import com.example.runeforum.PostService.Logic.PostModel;
import com.example.runeforum.ReactionService.DAL.ReactionDTO;
import com.example.runeforum.ReactionService.ReactionListConverter;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@Getter @Setter
public class PostDTO implements Serializable
{
    private int ID;
    private String Title;
    private String Text;
    private ZonedDateTime Date;
    private List<ReactionDTO> Reactions;


    public PostDTO(PostModel postModel)
    {
        ReactionListConverter reactionListConverter = new ReactionListConverter();

        this.ID = postModel.getID();
        Title = postModel.getTitle();
        Text = postModel.getText();
        Date = postModel.getDate();
        Reactions = reactionListConverter.ReactionModelToReactionDTO(postModel.getReactions());
    }
}
