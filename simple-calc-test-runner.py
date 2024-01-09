import subprocess
import argparse
import os

def run_command(command, reports_dir, logs_dir):
    """
    Executes a given command and saves its output to specified directories.

    Args:
    command (list): The command to be executed as a list of strings.
    reports_dir (str): Directory where reports will be saved.
    logs_dir (str): Directory where stdout and stderr logs will be saved.

    The function creates the necessary directories for reports and logs,
    executes the command, and captures its stdout and stderr.
    """
    try:
        # Create the reports and logs directories if they don't exist
        os.makedirs(reports_dir, exist_ok=True)
        os.makedirs(logs_dir, exist_ok=True)

        # Paths for stdout and stderr log files
        stdout_log_path = os.path.join(logs_dir, 'stdout.log')
        stderr_log_path = os.path.join(logs_dir, 'stderr.log')

        # Execute the command and redirect stdout and stderr to log files
        with open(stdout_log_path, 'w') as stdout_file, open(stderr_log_path, 'w') as stderr_file:
            subprocess.run(command, stdout=stdout_file, stderr=stderr_file, check=True)

    except subprocess.CalledProcessError as e:
        print(f"Command '{e.cmd}' returned non-zero exit status {e.returncode}.")
    except Exception as e:
        print(f"An error occurred: {e}")

def main():
    """
    Main function to parse arguments and initiate the test run process.

    The script accepts arguments to determine the type of tests to run,
    the directory to save reports, and the directory to save logs.
    """
    parser = argparse.ArgumentParser(description="SimpleCalc Test Runner")
    parser.add_argument("--run", choices=['unittests', 'scenarios'], required=True, help="Type of tests to run")
    parser.add_argument("--reports-dir", required=True, help="Directory to save reports")
    parser.add_argument("--logs-dir", default="logs", help="Directory to save logs")

    args = parser.parse_args()

    # Determine the command based on the type of test to run
    if args.run == 'unittests':
        command = ['gradle', 'unitTests', f'-PreportsDirProperty={args.reports_dir}/unit_tests']
        reports_dir = os.path.join(args.reports_dir, 'unit_tests')
    elif args.run == 'scenarios':
        command = ['gradle', 'test', f'-PreportsDirProperty={args.reports_dir}/bdd_scenarios']
        reports_dir = os.path.join(args.reports_dir, 'bdd_scenarios')

    # Run the command with specified reports and logs directories
    run_command(command, reports_dir, args.logs_dir)

if __name__ == "__main__":
    main()
