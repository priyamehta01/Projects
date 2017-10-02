<?php
$ldap = ldap_connect("10.20.10.51");
$error = false;
if (isset($_POST['username']) && isset($_POST['password'])) {
    $username = $_POST['username'];
    $password = $_POST['password'];
    if (!empty($username) && !empty($password)) {
        if ($bind = @ldap_bind($ldap, $username, $password)) {
            $user_id = $username;
            $_SESSION['user_id'] = $user_id;
            header('Location: vote.php'); //Specifiy the page you want to go to after login
        } else {
            $error = true;
        }
    }
}
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
    </head>
    <body>

        <form class="form form-validate floating-label" action="<?php echo $current_file; ?>" accept-charset="utf-8" method="post" novalidate="novalidate">
            <div class="form-group">
				<label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
				<label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <br/>

            <div class="row">
                <!--end .col -->
                <div class="col-lg-12 text-right">
                    <button class="btn btn-primary btn-raised" type="submit">Login</button>
                </div>
                <!--end .col -->
            </div>

            <div class="row">
                <!--end .col -->
                <div class="col-lg-12 text-center">
                    <?php
                    if ($error) {
                        echo '<br/><br/><font color="red"><b>Invalid username/password.</b></font>';
                    }
                    ?>
                </div>
                <!--end .col -->
            </div>
            <!--end .row -->
        </form>

    </body>
</html>
