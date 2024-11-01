select shelters.shelter_name, count(animals.animal_id) as animal_count
from shelters left join animals on shelters.shelter_id = animals.shelter_id
group by shelters.shelter_id;