printjson(
	db.people.aggregate([
		{ $group: 
			{ _id: null, 
			uniqueJob: { $addToSet: "$job" } 
			} 
		}
	]).toArray()
);