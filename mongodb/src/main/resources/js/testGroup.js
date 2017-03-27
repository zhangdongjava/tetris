/**
 * Created by zd on 2017/3/24.
 */
db.getCollection('userScore22').group({

    keyf: function (doc) {
        return {groupDate: doc.insertDate.getFullYear() + "-" + (doc.insertDate.getMonth() + 1) + "-" + doc.insertDate.getDate()}
    },
    cond: {},
    reduce: function (curr, result) {
        if (curr.hour > result.hour) {
            result.score = curr.score;
            result.hour = curr.hour;
            result.dirll = curr.drill;
        }
    },
    initial: {
        hour: 0
    }
})
