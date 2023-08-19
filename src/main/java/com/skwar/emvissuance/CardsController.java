package com.skwar.emvissuance;

import com.skwar.emvissuance.model.CardProgram;
import com.skwar.emvissuance.model.ChipData;
import com.skwar.emvissuance.model.EMVTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/cards")
public class CardsController {
    @PostMapping("/configurations/createCardProfile")
    public String CreateCardProfile (CardProgram program , EMVTemplate template)
{

    return "MD_CONFIGURATION_UU1";
}
@PostMapping("/generateChipData")
public ChipData GenerateChipData (String configurationId , String dynamicPersoData , String encryptionMetaData)
{
    ChipData chipData= new ChipData();

    return chipData;
}


}
