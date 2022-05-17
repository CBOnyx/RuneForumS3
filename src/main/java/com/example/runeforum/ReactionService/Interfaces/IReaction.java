package com.example.runeforum.ReactionService.Interfaces;

import com.example.runeforum.ReactionService.DAL.ReactionDTO;

public interface IReaction
{
    void SaveReaction(ReactionDTO reactionDTO);
    void DeleteReaction(long id);
    void UpdateReactionText(long id, String text);
}
