printjson(db.people.aggregate([
	{ 
		$group: {
			_id: "$nationality", 
			avg_BMI: { 
				$avg: {
					$divide: ["$weight",{$pow: [{$divide: ["$height", 100]},2]}]
				}
			}
			,min_BMI: { 
				$min: {
					$divide: ["$weight",{$pow: [{$divide: ["$height", 100]},2]}]
				}
			}
			,max_BMI: { 
				$max: {
					$divide: ["$weight",{$pow: [{$divide: ["$height", 100]},2]}]
				}
			}
		} 
	}
]).toArray())