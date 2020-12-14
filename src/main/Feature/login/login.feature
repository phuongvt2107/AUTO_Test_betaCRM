Feature: Người dùng truy cập vào domain của onsales

  Scenario Outline: Người dùng truy cập thành công vào hệ thống domain của onsales
    Given Người dùng đang ở trang đăng nhập
    When Người dùng đăng nhập vào hệ thống bằng tài khoản có thông tin
      | username   | password   |
      | <username> | <password> |
    Then Người dùng đăng nhập thành công vào hệ thống
    Examples:
      | username                  | password       |
      | vtphuong2107@gmail.com    | 123456789      |
      | parisavuthi@gmail.com     | 123456789      |
      | phuongvt2107@gmail.com    | 123456789      |