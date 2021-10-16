printjson(db.people.aggregate([
	{ 
		$group: {
			_id: "$nationality", 
			avg_BMI: { 
				$avg: {
					$divide: [ { $toDouble: "$weight" },{$pow: [{$divide: [ { $toDouble: "$height" }, 100]},2]}]
				}
			}
			,min_BMI: { 
				$min: {
					$divide: [ { $toDouble: "$weight" },{$pow: [{$divide: [ { $toDouble: "$height" }, 100]},2]}]
				}
			}
			,max_BMI: { 
				$max: {
					$divide: [ { $toDouble: "$weight" },{$pow: [{$divide: [ { $toDouble: "$height" }, 100]},2]}]
				}
			}
		}
	},
		{ $sort : {"_id" : 1} }
]).toArray())