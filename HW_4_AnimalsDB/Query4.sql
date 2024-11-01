select animals.animal_id, animals.animal_name, 'YES' as adopted
from animals inner join adoptions on animals.animal_id = adoptions.animal_id

union

select animals.animal_id, animals.animal_name, 'NO' as adopted
from animals left join adoptions on animals.animal_id = adoptions.animal_id
where adoptions.animal_id is null;