package ru.ifmo.web.deploy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ifmo.web.database.entity.Menagerie;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
public class MenagerieWrapper {
    List<Menagerie> menagerie;
}
