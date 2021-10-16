printjson(
    db.people.aggregate([
        { $match: { sex: "Female", nationality: "Poland" } },
        { $unwind: "$credit" },
        { $group: {
				_id: "$credit.currency",
				"sum_balance": { $sum: { $toDouble: "$credit.balance" } },
				"avg": { $avg: { $toDouble: "$credit.balance" } },
            }
        },
        { $project: {
                _id: 0,
                waluta: "$_id",
                "avg": 1,
                "sum_balance": 1
            }
        },
		{ $sort: { waluta: 1 } }
    ]).toArray()
);