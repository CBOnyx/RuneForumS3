package com.example.runeforum.PostService;

import com.example.runeforum.PostService.API.PostViewModel;
import com.example.runeforum.PostService.DAL.PostDTO;
import com.example.runeforum.PostService.DAL.PostEntity;
import com.example.runeforum.PostService.Logic.PostModel;
import com.example.runeforum.ReactionService.API.ReactionViewModel;
import com.example.runeforum.ReactionService.DAL.ReactionDTO;
import com.example.runeforum.ReactionService.DAL.ReactionEntity;
import com.example.runeforum.ReactionService.Logic.ReactionModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PostListConverter
{
    @NotNull
    public List<PostDTO> PostModelToPostDTO( List<PostModel> postModels)
    {
        List<PostDTO> postDTOS = new ArrayList<>();
        postModels.forEach(postModel -> postDTOS.add(new PostDTO(postModel)));
        return postDTOS;
    }

    @NotNull
    public List<PostModel> PostDTOToPostModel(List<PostDTO> postDTOS)
    {
        List<PostModel> postModels = new ArrayList<>();
        postDTOS.forEach(postDTO -> postModels.add(new PostModel(postDTO)));
        return postModels;
    }

    @NotNull
    public List<PostModel> PostViewModelToPostModel(List<PostViewModel> postViewModels)
    {
        List<PostModel> postModels = new ArrayList<>();
        postViewModels.forEach(postViewModel -> postModels.add(new PostModel(postViewModel)));
        return postModels;
    }

    @NotNull
    public List<PostViewModel> PostModelToPostViewModel(List<PostModel> postModels)
    {
        List<PostViewModel> postViewModels = new ArrayList<>();
        postModels.forEach(postModel -> postViewModels.add(new PostViewModel(postModel)));
        return postViewModels;
    }

    @NotNull
    public List<PostDTO> PostEntityToPostDTO(List<PostEntity> postEntities)
    {
        List<PostDTO> postDTOS = new ArrayList<>();
        postEntities.forEach(postEntity -> postDTOS.add(new PostDTO(postEntity)));
        return postDTOS;
    }

    @NotNull
    public List<ReactionEntity> PostDTOToPostEntity(List<PostDTO> reactionDTOS)
    {
        List<ReactionEntity> reactionEntities = new ArrayList<>();
        reactionDTOS.forEach(postDTO -> reactionEntities.add(new ReactionEntity(postDTO)));
        return reactionEntities;
    }
}
