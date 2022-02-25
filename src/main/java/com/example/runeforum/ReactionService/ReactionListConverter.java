package com.example.runeforum.ReactionService;

import com.example.runeforum.ReactionService.API.ReactionViewModel;
import com.example.runeforum.ReactionService.DAL.ReactionDTO;
import com.example.runeforum.ReactionService.Logic.ReactionModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ReactionListConverter
{

    @NotNull
    public List<ReactionDTO> ReactionModelToReactionDTO(List<ReactionModel> reactionModels)
    {
        List<ReactionDTO> reactionDTOS = new ArrayList<>();
        reactionModels.forEach(reactionModel -> reactionDTOS.add(new ReactionDTO(reactionModel)));
        return reactionDTOS;
    }

    @NotNull
    public List<ReactionModel> ReactionDTOToReactionModel(List<ReactionDTO> reactionDTOS)
    {
        List<ReactionModel> reactionModels = new ArrayList<>();
        reactionDTOS.forEach(reactionDTO -> reactionModels.add(new ReactionModel(reactionDTO)));
        return reactionModels;
    }

    @NotNull
    public List<ReactionModel> ReactionViewModelToReactionModel(List<ReactionViewModel> reactionViewModels)
    {
        List<ReactionModel> reactionModels = new ArrayList<>();
        reactionViewModels.forEach(reactionViewModel -> reactionModels.add(new ReactionModel(reactionViewModel)));
        return reactionModels;
    }

    @NotNull
    public List<ReactionViewModel> ReactionModelToReactionViewModel(List<ReactionModel> reactionModels)
    {
        List<ReactionViewModel> reactionViewModels = new ArrayList<>();
        reactionModels.forEach(reactionModel -> reactionViewModels.add(new ReactionViewModel(reactionModel)));
        return reactionViewModels;
    }
}
