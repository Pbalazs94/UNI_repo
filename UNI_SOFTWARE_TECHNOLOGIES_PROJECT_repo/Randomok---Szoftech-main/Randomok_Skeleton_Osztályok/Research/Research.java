package Research;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Research 
{
	List<String> lines = new ArrayList<String>();
	rows = Files.readAllLines(Path.get(research.txt, StandardCharsets.UTF_8));
	int length = lines.size()*3;
	String[] ResearchName;
	String[] ResearchCost;
	String[] ResearchTime;
	for (int i = 0; i<length-1; i += 3)
	{
		String[] temp = lines.get(i).split(",");
		ResearchName[i] = temp[0];
		ResearchCost[i+1] = temp[1];
		ResearchCost[i+2] = temp[2];
	}
}
