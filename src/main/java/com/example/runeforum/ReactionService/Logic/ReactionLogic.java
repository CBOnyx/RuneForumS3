package com.example.runeforum.ReactionService.Logic;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class ReactionLogic
{
    public ZonedDateTime ChangeDateToLocation(ZonedDateTime ReactionDate, String CountryCode)
    {
        if(ZonedDateTime.parse(CountryCode) != ReactionDate){
            return ZonedDateTime.parse(CountryCode);
        }
        return ReactionDate;
    }
}
