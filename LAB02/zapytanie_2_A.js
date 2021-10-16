printjson(
    db.people.aggregate([
        { $unwind: "$credit" // rozbicie obiektów/kart osobno
        },
        { $group: 
			{ _id: "$credit.currency",
            value: { $sum: { $toDouble: "$credit.balance" } }
            }
        },
		{ $sort : {"_id" : 1} }

    ]).toArray()
);