db.people.aggregate([
	{ $group: 
		{ _id: "$sex", 
		"avg_w": { $avg: { $toDouble: "$weight" }}, 
		"avg_h": { $avg: { $toDouble: "$height" }} 
		} 
	}
])