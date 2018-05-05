eApp.factory('place', function () {
    // 這裡可以放 private value，外面無法取得
    var value = 'Hello, 我是 private 值';
    return {
        register: 'assets/txn/register/register.html',
        memberInfo: 'assets/txn/memberInfo/memberInfo.html'
    }
})