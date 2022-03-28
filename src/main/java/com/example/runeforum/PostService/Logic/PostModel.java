package com.example.runeforum.PostService.Logic;

import com.example.runeforum.PostService.API.PostViewModel;
import com.example.runeforum.PostService.DAL.PostDTO;
import com.example.runeforum.PostService.DAL.PostEntity;
import com.example.runeforum.ReactionService.Logic.ReactionModel;
import com.example.runeforum.ReactionService.ReactionListConverter;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter @Setter
public class PostModel
{
    private long ID;
    private String Title;
    private String Text;
    private ZonedDateTime Date;
    private List<ReactionModel> Reactions;

    public PostModel(PostDTO postDTO)
    {
        ReactionListConverter reactionListConverter = new ReactionListConverter();

        this.ID = postDTO.getID();
        Title = postDTO.getTitle();
        Text = postDTO.getText();
        Date = postDTO.getDate();
        Reactions = reactionListConverter.ReactionDTOToReactionDTO(postDTO.getReactions());
    }

    public PostModel(PostViewModel postViewModel)
    {
        ReactionListConverter reactionListConverter = new ReactionListConverter();

        this.ID = postViewModel.getID();
        Title = postViewModel.getTitle();
        Text = postViewModel.getText();
        Date = postViewModel.getDate();
        Reactions = reactionListConverter.ReactionViewModelToReactionModel(postViewModel.getReactions());
    }
}
